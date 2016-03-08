
my $answer = 0;

for ($n = 1; $n <= 100; $n++) {
	for ($r = 1; $r <= $n; $r++) {
		$a = ( &factorial($n) / ( &factorial( $r ) * &factorial( $n - $r) ) );
		printf "n = %3d, r = %3d ==> %d\n", $n, $r, $a;
		if ($a > 1000000) {
			$answer++;
		}
	}
}
print "Answer = ".$answer."\n";


sub factorial {
    my ($m) = @_;

    return 1 if( $m <=1 );
    return $m * &factorial( $m - 1 );
}