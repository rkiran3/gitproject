// Exact match ==~ and match anywhere =~
def samples = ["   ", "234", "  123 45", "ccxy 12", "123a56"]
def pattern_test1 = ~/\s+/

// find the pattern ANYWHERE in each of the entries
myresult = samples.findAll{ it =~ pattern_test1 }
assert [ "   "  , "  123 45", "ccxy 12"] == myresult
assert myresult.size() == 3

// for exact matches use ==~, here search for consecutive digits
def pattern2 = ~/\d+/
// find exact pattern which contains only digits in the entry.
myresult = samples.findAll { it ==~ pattern2 }
assert [ "234"] == myresult


// pattern for 3 digits
def pattern = ~/\d{3}/
def inputs = ["123", "456", "7890"]
// Find all the input Strings that match the exact pattern of 3 digits
assert ["123", "456"] == inputs.findAll{  it ==~ pattern }

pattern = ~/\d/
input = "abc12ac567"
assert input =~ pattern
input.eachMatch (pattern) {
    print it  // print each integer (12567) in input String 
}


// Replace a pattern like -m2 or -2 with -d3
def pattern_test2 = ~/-(m*)2/
def input = "20456-m2"
assert "20456-d3".equals(input.replaceFirst (pattern_test2, "-d3"))
input = "20876-2"
assert "20876-d3".equals(input.replaceFirst (pattern, "-d3"))
def inputs_array = ["20456-m2", "20876-2"]
assert [ "20456-d3", "20876-d3"] == inputs_array.collect { it.replaceFirst (pattern, "-d3")}

// ----- Matcher with Groups

// 	pattern of 
//	digits followed by 
//	"m" followed by 
//	digits, followed by 
//	+/-, followed by
// 	another digit
def regex = /(\d*)m(\d*)[+|-](\d)/
def tPattern = Pattern.compile(regex)
def mixed_input = "10m2+7"
def tmatcher = tPattern.matcher(mixed_input)

if (tmatcher.find()) {	
	assert tmatcher.group(0) == mixed_input
	assert tmatcher.group(1) == "10"
	assert tmatcher.group(2) == "2"
	assert tmatcher.group(3) == "7"
} else {
	assert false
}

