
	$scoreLarry = 0;
	$scoreRobin = 0;


	for ($i = 0; $i < 50; $i++) {
		$number = int(rand(10)) + 1;


		foreach $key (keys %called){ 
			$called{$key}++;
		}
		$called{$number} = 0;

		if ( exists $larry{$number} ) { 
			$scoreLarry++;
		} else {
			if (scalar keys %larry > 4) {
				# remove by longest time not called
				$key = (sort {$called{$b} <=> $called{$a}} keys %called)[0];
				delete $larry{$key};
			}
			$larry{$number} = 0;

		}

		foreach $key (keys %robin){ 
			$robin{$key}++;
		}
		if ( exists $robin{$number} ) { 
			$scoreRobin++;
		} else {
			# remove by longest in memory
			if (scalar keys %robin > 4) {

				$key = (sort {$robin{$b} <=> $robin{$a}} keys %robin)[0];
				delete $robin{$key};
			}
			$robin{$number} = 0;
		}
		my $larrystr = join(", ", sort { $a <=> $b } map { "$_" } keys %larry);
		my $robinstr = join(", ", sort { $a <=> $b } map { "$_" } keys %robin);
		$j = $i + 1;
		print $j."\t"."\t".$scoreLarry."\t".$scoreRobin."\n";
	}
