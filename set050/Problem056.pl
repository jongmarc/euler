use bigint;
$max = 0;
for ($i = 1; $i < 100; $i++) {
	print "$i\n";
	for ($j = 1; $j < 100; $j++) {
		$a = $i ** $j;
		$sum = 0;
		foreach $digit ( split( //, $i ** $j ) ) {
			$sum += $digit;
		}
		$max = $sum if ($sum > $max);
	}
}
print "Answer = ".$max."\n";