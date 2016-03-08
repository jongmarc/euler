use bignum;
$a = 1;
$b = 1;
$term = 1;
while (length($a) < 1000) { 
	$c = $b;
	$b += $a;
	$a = $c;
	$term++;
}
print "Answer = ".$term;

__END__
while ()

while

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144