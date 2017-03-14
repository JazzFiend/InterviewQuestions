// This function raises the integer x to the y power
// and writes it to a database with a row identifier.
// Assume databaseWrite returns 0 when successful, 1 otherwise.
// You are encouraged to improve this code if you come up with any improvements

var exponentDatabaseWrite = function(rowId, x, y) {
  if(!Number.isInteger(x) || !Number.isInteger(y)) {
    throw new Error('Need integers');
  } else {
    var result = Math.pow(x, y);
    return databaseWrite(rowID, result);
  }
}




//Answer:
// Need to mock/stub databaseWrite for success and failure.
// Need a test where x and y aren't integers or undefined.
// The function should have a default value for rowID.
// Nice to have tests where x and y are zero or negative.

