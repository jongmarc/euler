%digits = (0, 1, 1, 1, 2, 2, 3, 6, 4, 24, 5, 120, 6, 720, 7, 5040, 8, 40320, 9, 362880);
my %cycle;

for ($i = 1; $i < 1000000; $i++) {
	if ( !$cycle{$i} ) {
		$cycle{$i} = &chain($i);
	}
}

my @all_matches = grep { $cycle{$_} == 60 } keys %cycle;
print("$_\n") foreach @all_matches;

print "Answer 74 = ".($#all_matches+1)."\n";


sub chain {
	my $number = shift;
	my $sum = $number;
	my $counter = 0;
	my %found;

	while ( !$found{$sum} && !$cycle{$sum} ) {
		$counter++;
		$found{ $sum } = $counter;
		print "--> ".$sum;
		
		foreach $digit ( split //, $sum ) {
			$new_sum += $digits{$digit};
		}
		$sum = $new_sum; $new_sum = 0;
	}
	$counter += $cycle{$sum};
	$cycle{$sum} = $counter + 1 - $found{$sum} if (!$cycle{$sum});
	print " -- > ".$number." = ".$counter."\n";
	return $counter;
}