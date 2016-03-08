$sum = 0;
my $q = 0;
for ($i = 1023456789; $i < 9876543210; $i++) {
	my $z = substr($i, 0, 3);
	if ($z ne $q) {
		print time." - ".$z."\n";
		$q = $z;
	}

	if (isPandigital($i)) {
		if (isDivisible($i)) {
			print $i."\n";
			$sum += $i;
		}
	}	

}
print "Answer = ".$sum."\n";
sub isPandigital{
	my $number = shift;
	my @unique = keys { map { $_ => 1 } split //, $number };
	return ( $#unique + 1 == length($number) );
}

sub isDivisible {
	my $number = shift;
	my $a, $b, $c, $d, $e, $f, $g;
	($a, $d, $g) = $number =~ /\d(\d\d\d)(\d\d\d)(\d\d\d)/;
	return 0 if ($g % 17 != 0);
	return 0 if ($d % 7 != 0);
	return 0 if ($a % 2 != 0);
	($b, $e) = $number =~ /\d\d(\d\d\d)(\d\d\d)\d\d/;
	return 0 if ($e % 11 != 0);
	return 0 if ($b % 3 != 0);	
	($c, $f) = $number =~ /\d\d\d(\d\d\d)(\d\d\d)\d/;
	return 0 if ($f % 13 != 0);
	return 0 if ($c % 5 != 0);	
	return 1;
}