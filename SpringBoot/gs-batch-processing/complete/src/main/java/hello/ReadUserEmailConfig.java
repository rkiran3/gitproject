package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.H2PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlServerPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class ReadUserEmailConfig {
    private static final Logger log = LoggerFactory.getLogger(ReadUserEmailConfig.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    private static final String QUERY_FIND_STUDENTS =
            "SELECT emailAddress " +
                "FROM Person.EmailAddress " +
                "ORDER BY EmailAddress ASC";

    /*@Bean
    ItemReader<UserEmail> databaseXmlItemReader(DataSource dataSource) {
        JdbcCursorItemReader<UserEmail> databaseReader = new JdbcCursorItemReader<>();

        databaseReader.setDataSource(dataSource);
        databaseReader.setSql(QUERY_FIND_STUDENTS);
        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(UserEmail.class));

        return databaseReader;
    }*/

    private LineAggregator<UserEmail> createStudentLineAggregator() {
        log.info("In createStudentLineAggregator ");
        DelimitedLineAggregator<UserEmail> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(";");

        FieldExtractor<UserEmail> fieldExtractor = createStudentFieldExtractor();
        lineAggregator.setFieldExtractor(fieldExtractor);

        log.info("In createStudentLineAggregator - returning lineAggregator");
        return lineAggregator;
    }

    private FieldExtractor<UserEmail> createStudentFieldExtractor() {
        log.info("In databaseCsvItemWriter" );

        BeanWrapperFieldExtractor<UserEmail> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String[] {"emailAddress"});
        log.info("In databaseCsvItemWriter returning extractor" );
        return extractor;
    }

    @Bean
    ItemWriter<UserEmail> databaseCsvItemWriter() {
        log.info("In databaseCsvItemWriter" );
        FlatFileItemWriter<UserEmail> csvFileWriter = new FlatFileItemWriter<>();

        // Specify the column names required in output like:      EmailAddress;EmailFormat
        String exportFileHeader = "EmailAddress";

        StringHeaderWriter headerWriter = new StringHeaderWriter(exportFileHeader);
        csvFileWriter.setHeaderCallback(headerWriter);

        String exportFilePath = "personemails.csv";
        csvFileWriter.setResource(new FileSystemResource(exportFilePath));

        LineAggregator<UserEmail> lineAggregator = createStudentLineAggregator();
        csvFileWriter.setLineAggregator(lineAggregator);

        log.info("In databaseCsvItemWriter returning csvFileWriter" );
        return csvFileWriter;
    }

    @Bean
    public UserEmailItemProcessor processor() {
        return new UserEmailItemProcessor();
    }

    @Bean
    //ItemReader<UserEmail> databaseCsvItemReader(DataSource dataSource) {
    ItemReader<UserEmail> databaseCsvItemReader() {
        log.info("Calling databaseCsvItemReader");

        JdbcPagingItemReader<UserEmail> databaseReader = new JdbcPagingItemReader<>();

        databaseReader.setDataSource(dataSource);
        databaseReader.setPageSize(1);

        PagingQueryProvider queryProvider = createQueryProvider();
        databaseReader.setQueryProvider(queryProvider);

        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(UserEmail.class));

        log.info("Calling databaseCsvItemReader returning databaseReader" );
        return databaseReader;
    }

    private PagingQueryProvider createQueryProvider() {
        log.info("In createQueryProvider" );

        SqlServerPagingQueryProvider queryProvider = new SqlServerPagingQueryProvider();

        // provide the query required to fetch records from db
        queryProvider.setSelectClause("select EmailAddress ");
        queryProvider.setFromClause("from Person.EmailAddress");
        queryProvider.setSortKeys(sortByEmailAddressAsc());

        return queryProvider;
    }

    private Map<String, Order> sortByEmailAddressAsc() {
        Map<String, Order> sortConfiguration = new HashMap<>();
        sortConfiguration.put("EmailAddress", Order.ASCENDING);
        return sortConfiguration;
    }

    @Bean
    //public Job importUserJob(JobCompletionNotificationListener listener) {
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                //.listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<UserEmail, UserEmail> chunk(10)
                .reader(databaseCsvItemReader())
                .processor(processor())
                .writer(databaseCsvItemWriter())
                .build();
    }
    // end::jobstep[]
}