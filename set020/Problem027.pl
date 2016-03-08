use Math::Prime::XS qw(primes is_prime);

$maxN = 0;
$maxA = 0;
$maxB = 0;
for ($a = -1000; $a <= 1000; $a++ ) {
	for ($b = -1000; $b <= 1000; $b++ ) {
		$foundNonPrime = 0;
		$n = 0;
		while (!$foundNonPrime) {
			if ($n ** 2 + $a * $n + $b > 0) {
				$foundNonPrime = is_prime($n ** 2 + $a * $n + $b) ? 0 : 1;
			} else {
				$foundNonPrime = 1;
			}
			$n++;
			if ($n > 1000){
				print "Illegal exit at a=".$a.",b=".$b.",n=".$n."\n";
				exit(0);
			}
		}
		if ($n > $maxN) {
			$maxN = $n;
			$maxA = $a;
			$maxB = $b;
			print "Found ".$n."^2 + ".$a."*".$n." + ".$b."\n";
		}
	
	}
}
print "Answer = ".($maxA * $maxB)."\n";

