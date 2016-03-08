
open(FILE,"<p059_cipher.txt");
	$line = <FILE>;
close(FILE);

$i=0;
foreach $char (split ",", $line ) {
	$count{$i."-".$char}++;
	$i++;
	$i = 0 if ($i == 3);
}
print"\n";

foreach $count (keys %count) {
	$idx = substr($count, 0, 1);
	$key = substr($count, 2);
	if ($count{$count} > $max[$idx]) {
		$max[$idx] = $count{$count};
		$key[$idx] = $key;
	}
}
$i = 0;
$answer = 0;
foreach $char (split ",", $line ) {
	print chr($char ^ ($key[$i] ^ 32));
	$answer += $char ^ ($key[$i] ^ 32);
	$i++;
	$i = 0 if ($i == 3);	
}
print "\nAnswer = ".$answer."\n";