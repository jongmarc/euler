my $i = 10;
while (1==1) {
	my $sum = 0;
	foreach $digit ( $i=~/./g ) {
		$sum += $digit ** 5;
		last if ($sum > $i);
	}
	if ( $i == $sum ) {
		$total += $i;
		print "Found ".$i." which gives total: ".$total."\n";
	}

	$i++;
}