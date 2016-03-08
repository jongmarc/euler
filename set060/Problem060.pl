use ntheory qw/is_prime/;

# build list of primes
for ( my $i = 0; $i < 10000; $i++ ) {
	if ( is_prime( $i ) ) {
		push @primes, $i;
	}
}

for ($i = 0; $i < $#primes; $i++) {
	for ($j = $i + 1; $j < $#primes; $j++) {
		next if (!is_prime($primes[$i].$primes[$j]) || !is_prime($primes[$j].$primes[$i]));
		print ".";
		for ($k = $j + 1; $k < $#primes; $k++) {
			next if (!is_prime($primes[$i].$primes[$k]) || !is_prime($primes[$k].$primes[$i]));
			next if (!is_prime($primes[$j].$primes[$k]) || !is_prime($primes[$k].$primes[$j]));
			for ($l = $k + 1; $l < $#primes; $l++) {
				next if (!is_prime($primes[$i].$primes[$l]) || !is_prime($primes[$l].$primes[$i]));
				next if (!is_prime($primes[$j].$primes[$l]) || !is_prime($primes[$l].$primes[$j]));
				next if (!is_prime($primes[$k].$primes[$l]) || !is_prime($primes[$l].$primes[$k]));
				for ($m = $l + 1; $m < $#primes; $m++) {
				 	next if (!is_prime($primes[$i].$primes[$m]) || !is_prime($primes[$m].$primes[$i]));
				 	next if (!is_prime($primes[$j].$primes[$m]) || !is_prime($primes[$m].$primes[$j]));
				 	next if (!is_prime($primes[$k].$primes[$m]) || !is_prime($primes[$m].$primes[$k]));
				 	next if (!is_prime($primes[$l].$primes[$m]) || !is_prime($primes[$m].$primes[$l]));
					print "Found ".$primes[$i].", ".$primes[$j].", ".$primes[$k].", ".$primes[$l].", ".$primes[$m]."\n";
					print "Answer = ".($primes[$i] + $primes[$j] + $primes[$k] + $primes[$l] + $primes[$m])."\n";
					exit(0);
				 }
			}
		}
	}
}



