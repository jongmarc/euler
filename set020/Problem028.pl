
# 21 22 23 24 25 26
# 20  7  8  9 10 27
# 19  6  1  2 11 28
# 18  5  4  3 12 29
# 17 16 15 14 13 30 
#				 31

#1 
#3 5 7 9   +  2
#13 17 21 25 + 4
#31 37 43 50 + 6

$sum = 1;
$inc = 2;
$index = 1;

for ( $i = 3; $i <= 1001; $i = $i + 2) {
	for ( $j = 0; $j < 4; $j++) {
		$index += $inc;
		$sum += $index;
	}
	$inc += 2;
}
print $sum;