use Math::Prime::Util 'gcd';
use POSIX;

$answerN = 0;
$answerD = 0;
$max = 0;
for ($d = 2; $d <= 1000000; $d++) {
	$n = ceil(3/7 * $d);
	print $n." \\ ".$d." = ".($n/$d)." with gcd ".gcd($n, $d);
	if ($n/$d >= 3/7) {
		print " is too big\n";
	} else {
		print " is good.\n";
	}

	while ( $n/$d >= 3/7 && $n >= 1 ) {
		$n--;
	}

	while ( gcd($n, $d) != 1 && $n >= 1 ) {
		$n--;
	}
	if ( $n >= 1 ) {
		print $n." / ".$d." = ".($n/$d)." with gcd ".gcd($n, $d);
		if ($n/$d >= 3/7) {
			print " is too big\n";
		} else {
			print " is good.\n";
		}
	} else {	
		print "$n and $ d find no solution";
	}
	if ( $n / $d > $max ) {
		$max = $n / $d;
		$answerN = $n;
		$answerD = $d;
	}
	print "----\n";
}
print "Answer 71 =".$answerN."/".$answerD."\n";
