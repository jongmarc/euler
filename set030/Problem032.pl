$number = 987654321;


for ($a = 1; $a <= 99; $a++){
	for ($b = 1; $b <= 9876; $b++){
		if (length($a.$b.($a*$b)) == 9 && isPandigital($a.$b.($a*$b))) {
			print $a." * ".$b." = ".($a*$b)."\n";
			$uniquesum{$a*$b} = 1;
		}
		
	}
}
my $uniquesum = 0;
foreach $uniquevalue (keys %uniquesum) {
	$uniquesum += $uniquevalue;
}
print "Answer = ".$uniquesum."\n";

sub isPandigital{
	my $number = shift;
	return 0 if ( $number =~ /0/ || $number < 1 ); 
	my @unique = keys { map { $_ => 1 } split //, $number };
	return ( $#unique + 1 == length($number) );
}
