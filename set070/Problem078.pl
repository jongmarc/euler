use Math::Prime::Util 'partitions';
use bigint;
$i = 1;
while (1==1) {
	if (partitions($i) % 1000000 == 0) {
		print "Answer = ".$i."\n";
		exit(0);
	} 
	$i++;
	print $i."\n";
}
