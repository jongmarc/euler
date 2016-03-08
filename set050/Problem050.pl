use ntheory qw/is_prime/;

# build list of primes
for ( my $i  = 0; $i < 1000000; $i++ ) {
	if ( is_prime( $i ) ) {
		push @primes, $i;
	}
}

$i = 0;
while ($sum < 1000000) {
	$sum += $primes[$i];
	$i++;
}
$sum -= $primes[$i - 1];
$i = 0;
while ( !is_prime($sum) ) {
	$sum -= $primes[$i];	
}
print $sum;

