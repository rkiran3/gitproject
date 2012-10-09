// pattern for 3 digits
def pattern = ~/\d{3}/

def inputs = ["123", "456", "7890"]

// Find all the input Strings that match the exact pattern of 3 digits
assert ["123", "456"] == inputs.findAll{  it ==~ pattern }

// ----- Matcher with Groups

// 	pattern of 
//	digits followed by 
//	"m" followed by 
//	digits, followed by 
//	+/-, followed by
// 	another digit
def regex = /(\d*)m(\d*)[+|-](\d)/
def tPattern = Pattern.compile(regex)
def input = "10m2+7"
def tmatcher = tPattern.matcher(input)

if (tmatcher.find()) {	
	assert tmatcher.group(0) == input
	assert tmatcher.group(1) == "10"
	assert tmatcher.group(2) == "2"
	assert tmatcher.group(3) == "7"
} else {
	assert false
}

