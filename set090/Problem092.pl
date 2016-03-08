%digits = (0, 1, 1, 1, 2, 2, 3, 6, 4, 24, 5, 120, 6, 720, 7, 5040, 8, 40320, 9, 362880);
my %cycle;

for ($i = 1; $i <10000000; $i++) {
	print "$i\n" if ($i % 10000 == 0);
	if ( !$cycle{$i} ) {
		$cycle{$i} = &chain($i);
	}
}

my @all_matches = grep { $cycle{$_} == 89 } keys %cycle;
#print("$_\n") foreach @all_matches;

print "Answer 92 = ".($#all_matches+1)."\n";


sub chain {
	my $number = shift;
	my $new = 0;
	#print "--> ".$number;
	foreach $digit ( split //, $number ) {
		$new += $digit ** 2;
	}
	
	if ( $new != 1 && $new != 89 ) {
		$cycle{$number} = &chain($new);
		return $cycle{$number};
	} else {
		return $new;
	}
}


