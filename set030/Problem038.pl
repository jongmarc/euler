

for ($i = 1; $i < 98765; $i++) {
	$concat = "";
	for ($j = 1; $j < 9; $j++) {
		$concat .= $i*$j;
#		print $i." - ".$j." - ".$concat."\n";
		if (length($concat) == 9 && isPandigital($concat)) {
			print $i.",".$j.",".$concat."\n";
		}
	}
	

}


sub isPandigital{
	my $number = shift;
	return 0 if ( $number =~ /0/ || $number < 1 ); 
	my @unique = keys { map { $_ => 1 } split //, $number };
	return ( $#unique + 1 == length($number) );
}
