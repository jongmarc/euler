use Math::Prime::Util 'gcd';

$answer = 0;

for ($d = 2; $d <= 12000; $d++) {
	if ($d % 100 == 0) { 
		print "$d\n";
	}
	for ($n = 1; $n < $d; $n++) {
		if (gcd($n, $d) == 1) {
			if ($n/$d > 1/3 and $n/$d < 1/2) {
				$answer++;
			}
		}
	}
}
print "Answer 73 =".$answer."\n";
