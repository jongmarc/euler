use ntheory qw/is_prime/;

	# 			31
 # 17 16 15 14 13 30
 # 18  5  4  3 12 29
 # 19  6  1  2 11 28 
 # 20  7  8  9 10 27
 # 21 22 23 24 25 26

 # 1 
 # 4 x + 2
 # 4 x + 4
 # 4 x + 6
$index = 1;
$inc = 2;
$primes = 0;
$non_primes = 1;
while (1 == 1) {
	for ($i = 0; $i < 4; $i++) {
		$index += $inc;
		if (is_prime($index)) {
			$primes++;
		} else {
			$non_primes++;
		}
	}

	if ($primes / ($primes + $non_primes) < 0.1 ) {
		print "Answer = ".($inc + 1)." (primes = ".$primes.", non primes = ".$non_primes.")\n";	
		exit(0);
	}
	$inc += 2;
}
