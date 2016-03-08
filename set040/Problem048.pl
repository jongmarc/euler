use bigint;

$digits = 0;

for ($i=1; $i <= 1000; $i++) {
	$digits += ($i ** $i) % 100000000000;
	#print $digits."\n";
}
print "Answer = ";
print substr $digits, -10;
print "\n";