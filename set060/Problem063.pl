use bigint;
$number = 1;
$power = 1;
$answer = 0;

while (1==1) {
	if ( length( $number ** $power ) == $power ) {
		$answer++;
		print "$answer ) ".($number ** $power)." = ".$number."^".$power."\n";
		$number++;
	} elsif ( length( $number ** $power ) < $power ) {
		$number++;
	} else {
		$number = 1;
		$power++;
	}
}