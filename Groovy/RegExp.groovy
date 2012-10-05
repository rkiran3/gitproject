
// pattern for 3 digits
def pattern = ~/\d{3}/

def inputs = ["123", "456", "7890"]

// Find all the input Strings that match the exact pattern of 3 digits
assert ["123", "456"] == inputs.findAll{  it ==~ pattern }
