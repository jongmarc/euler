
# Generate list of triangle numbers
for ($i = 1; $i <= 1000000; $i++){

	$triangle{ &triangle($i) } = 1;
	#print &triangle($i)." ";;
}

open (FILE, "<p042_words.txt");
	@file = <FILE>;
close (FILE);
$file = join ("", @file); $file = substr($file, 1, length($file)-2);
@words = split "\",\"", $file ;
$found = 0;
foreach $word (@words) {
	$ord_sum = 0;
	$ord_sum += ( (ord $_) - 64 ) foreach split //, $word;
	#print $word." --> ". $ord_sum."\n";
	if (isTriangle($ord_sum)) {
		$found++;
		print "Found ".$word."\n";
	}
	else {
	print "Skipping ".$word."\n";	
	}
}
print "Answer = ".$found."\n";
exit(0);


sub isTriangle{ 
	my $n = shift;
	return $triangle{ $n } == 1;
}

sub triangle{ 
	my $n = shift;
	return 0.5*$n*($n+1);
}