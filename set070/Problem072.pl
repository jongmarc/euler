use Math::Prime::Util 'gcd';
$answer = 0;
for ($d = 2; $d <= 1000000; $d++) {
	if ($d % 100 == 0) { print "$d\n";}
	for ($n = 1; $n < $d; $n++) {
		if (gcd($n, $d) == 1) {
			$answer++;
		}
	}
}
print "Answer 72 =".$answer."\n";
