
#use bignum;
$start = int(sqrt(102030405060708090)); # minimal template
$found = 0;
$test= 0;
while ($found == 0 && $test < 1929394959697989990) { # maximum template
	$start++;
	$test= $start*$start;
#	print $test;
	if (($test) =~ /^1.2.3.4.5.6.7.8.9.0/){
		print "Answer = ".$start."\n";
		$found = 1;
	} else {
		#print ($start*$start)."\n";
	}
}
