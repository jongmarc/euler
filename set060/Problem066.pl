

$max = 0;
$answer = 0;
foreach $d ( @{ [0 .. 1000] } ) {
	next if ( sqrt($d) == int( sqrt($d) ) );

	my $index = 1;
	while ( sqrt($d * $index ** 2 + 1) != int ( sqrt($d * $index ** 2 + 1) ) ) {
		$index++;
	}	
	if (sqrt($d * $index ** 2 + 1) > $max) {
		print "$d ==> ";
		print sqrt($d * $index ** 2 + 1);
		print "^2 - ".$d." x ".$index."^2 = 1\n";

		$max = sqrt($d * $index ** 2 + 1);
		$answer = $d;
	}
	
}
print "Answer = ".$answer."\n";
