$answer = 0;
for ($p = 3; $p <= 1000; $p++) {
	print "Processing ".$p."\n";
	$solutions = 0;
	for ($a = 1; $a <= $p - 2; $a++) {
		for ($b = 1; $b <= $p - 1 - $a; $b++) {
			$c = $p - $a -$b;
			if ($a ** 2 + $b ** 2 == $c ** 2) {
				$solutions++;
				print "{".$a.", ".$b.", ".$c."}, ";
			}
		}
	}
	print "\n" if ($solutions > 0);
	if ($solutions > $max_solutions) {
		print "Found new max: ".$solutions."\n";
		$max_solutions = $solutions;
		$answer = $p;
	}
}
print "Found answer: ".$answer."\n";
