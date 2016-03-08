


for ($i = 1; $i < 10000; $i++) {
	$pent{getPentagonal($i)} = 1;
}

@k = keys(%pent);
@j = keys(%pent);
$found = 999999999999;
for ($i = 0; $i < $#k; $i++) {
	for ($j = i; $j < $#j; $j++) {
		if ($pent{$k[$i] + $j[$j]} == 1 && $pent{abs($k[$i] - $j[$j])} == 1 && $k[$i] != $j[$j]) {
			if (abs($k[$i] - $j[$j]) < $found) {
				$found = abs($k[$i] - $j[$j]);
				print "Found ".$k[$i]." and ".$j[$j]."(".$found.")\n";
			}
		}
	}
}


sub getPentagonal {
	my $number = shift;
	return $number * (3 * $number - 1) / 2;
}