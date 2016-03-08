
# Ordered least to greatest
my @suit = qw(C D H S);
my @rank = ( 2 .. 9, qw(T J Q K A) );
	my %ord_suit = map { $suit[$_] => $_ } ( 0 .. $#suit );
	my %ord_rank = map { $rank[$_] => $_ } ( 0 .. $#rank );

open(FILE, "<p054_poker.txt");
	@lines = <FILE>;
close(FILE);

$win= 0;
	foreach $line (@lines) {

		@line = split /\s/, $line;
		if (&getPokerValue(@line[0..4]) > &getPokerValue(@line[5..9])) {
			$win++;
		}
	}
	print "Answer = ".$win."\n";
# &getPokerValue("8C","TS","KC","9H","4S");
# &getPokerValue("7D","2S","5D","3S","AC");
# &getPokerValue("7D","2D","5D","3D","AD");
# &getPokerValue("KD","QD","JD","TD","AD");
# &getPokerValue("8D","4D","5D","7D","6D");
# &getPokerValue("9D","6D","5D","8D","7D");
# &getPokerValue("TD","6D","TH","TC","TS");
# &getPokerValue("AD","6D","6H","AC","6S");
# &getPokerValue("7H","6D","4S","5C","8H");
# &getPokerValue("7H","6D","7S","7C","8H");
# &getPokerValue("7H","6D","7S","8C","8H");
# &getPokerValue("7H","6D","7S","8C","9H");
sub getPokerValue {
	my @cards = @_;
	my $return = 0;
	# sort by suit
	my @cards = map { $_->[0] } sort {
         $ord_suit{ $a->[1][1] } <=> $ord_suit{ $b->[1][1] }
      || $ord_rank{ $a->[1][0] } <=> $ord_rank{ $b->[1][0] }
	} map { [ $_, [m/(.*)(.)/] ] } @cards;

	print "@cards\n";	

	if (substr($cards[0], -1) eq substr($cards[1], -1) && 
		substr($cards[0], -1) eq substr($cards[2], -1) && 
		substr($cards[0], -1) eq substr($cards[3], -1) && 
		substr($cards[0], -1) eq substr($cards[4], -1) ) {
		
		if ($ord_rank{substr($cards[1], 0, 1)} == $ord_rank{substr($cards[0], 0, 1)} + 1 &&
			$ord_rank{substr($cards[2], 0, 1)} == $ord_rank{substr($cards[1], 0, 1)} + 1 &&
			$ord_rank{substr($cards[3], 0, 1)} == $ord_rank{substr($cards[2], 0, 1)} + 1 &&
			$ord_rank{substr($cards[4], 0, 1)} == $ord_rank{substr($cards[3], 0, 1)} + 1 ) {
			my $value = $ord_rank{substr($cards[0], 0, 1)} + $ord_rank{substr($cards[1], 0, 1)} + $ord_rank{substr($cards[2], 0, 1)} + $ord_rank{substr($cards[3], 0, 1)} + $ord_rank{substr($cards[4], 0, 1)};

			if ($ord_rank{substr($cards[1], 0, 1)} == 9) {
				print "- Royal Flush\n";
				return 1000000;
			} else {
				print "- Straight Flush of value ".($ord_rank{substr($cards[1], 0, 1)} + 1)."\n";
				return 9000000 + ($ord_rank{substr($cards[1], 0, 1)} + 1);
			}
		} else {
			print "- Flush \n";
			if (substr($cards[0], 0, 1) eq substr($cards[1], 0, 1)) {
				return 6000000 + $ord_rank{substr($cards[0], 0, 1)};
			} else {
				return 6000000 + $ord_rank{substr($cards[3], 0, 1)};
			}

		}	
	}

	# sort by rank
	my @cards = map { $_->[0] } sort {
      $ord_rank{ $a->[1][0] } <=> $ord_rank{ $b->[1][0] } ||
      $ord_suit{ $a->[1][1] } <=> $ord_suit{ $b->[1][1] }
	} map { [ $_, [m/(.*)(.)/] ] } @cards;

	if (substr($cards[1], 0, 1) eq substr($cards[2], 0, 1) &&
		substr($cards[1], 0, 1) eq substr($cards[3], 0, 1) && 
		( 	substr($cards[1], 0, 1) eq substr($cards[0], 0, 1) ||
			substr($cards[1], 0, 1) eq substr($cards[4], 0, 1) ) ) {
		print "- Four of a Kind of value ".($ord_rank{substr($cards[1], 0, 1)} + 2)."\n";
		$return += 8000000 + ($ord_rank{substr($cards[1], 0, 1)} + 2);
	}

	if (substr($cards[0], 0, 1) eq substr($cards[1], 0, 1) &&
		substr($cards[3], 0, 1) eq substr($cards[4], 0, 1) && 
		( 	substr($cards[0], 0, 1) eq substr($cards[2], 0, 1) ||
			substr($cards[3], 0, 1) eq substr($cards[2], 0, 1) ) ) {
		$value1 = substr($cards[2], 0, 1);
		$value2 = substr($cards[0], 0, 1) eq $value1 ? substr($cards[4], 0, 1) : substr($cards[0], 0, 1);
		print "- Full House with value ".($ord_rank{$value1} + 2)." and ".($ord_rank{$value2} + 2)."\n";
		return 7000000 + ($ord_rank{$value1} + 2) * 10000 + ($ord_rank{$value2} + 2);
	}


	if ($ord_rank{substr($cards[0], 0, 1)} + 1 == $ord_rank{substr($cards[1], 0, 1)} && 
		$ord_rank{substr($cards[1], 0, 1)} + 1 == $ord_rank{substr($cards[2], 0, 1)} && 
		$ord_rank{substr($cards[2], 0, 1)} + 1 == $ord_rank{substr($cards[3], 0, 1)} && 
		$ord_rank{substr($cards[3], 0, 1)} + 1 == $ord_rank{substr($cards[4], 0, 1)} ) {
		print "- Straight of value ".($ord_rank{substr($cards[4], 0, 1)})."\n";
		return 5000000 + ($ord_rank{substr($cards[4], 0, 1)});
	}
	if ((substr($cards[0], 0, 1) eq substr($cards[1], 0, 1) &&
		 substr($cards[1], 0, 1) eq substr($cards[2], 0, 1) ) || 
		(substr($cards[1], 0, 1) eq substr($cards[2], 0, 1) &&
		 substr($cards[2], 0, 1) eq substr($cards[3], 0, 1) ) || 
		(substr($cards[2], 0, 1) eq substr($cards[3], 0, 1) &&
		 substr($cards[3], 0, 1) eq substr($cards[4], 0, 1) ) ) {
		print "- Three of a Kind of value ".($ord_rank{substr($cards[2], 0, 1) }+ 2)."\n";
		$return += 4000000 + ($ord_rank{substr($cards[2], 0, 1) }+ 2);
	}
	undef %check;
	for ($i=0;$i<5;$i++){
		$check{$ord_rank{substr($cards[$i], 0, 1)}}++;
	}
	$pair = 0;
	$value1 = 0;
	$value2 = 0;
	foreach $rank ( keys %check ) {
		if ($check{$rank} == 2) {
			$pair ++;
			if ($value2 == 0) {
				$value2 = $rank;
			} elsif ($rank ne $value2) {
				$value1 = $rank;
			}

		}
	}
	if ($pair == 2) {
		print "- Found 2 pairs with values ".($value1 + 2)." and ".($value2 + 2)."\n";
		$return += 3000000 + ($value1 + 2) * 20000 + ($value2 + 2) * 5000;
	} elsif ($pair == 1) {
		print "- Found 1 pair with value".($value2 + 2)."\n";
		$return += 2000000 + ($value2 + 2) * 20000;
	} 
	print "- Found High Card with value ".($ord_rank{substr($cards[4], 0, 1)})."\n";
	$return += ($ord_rank{substr($cards[4], 0, 1)});
	
	


	
	print "@cards\n";	
	print "--------------\n";
return $return;

}

#8C TS KC 9H 4S 7D 2S 5D 3S AC
#5C AD 5D AC 9C 7C 5H 8D TD KS
#3H 7H 6S KC JS QH TD JC 2D 8S