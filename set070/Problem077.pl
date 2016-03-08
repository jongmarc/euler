
use Math::Prime::Util ':all';

#Show all prime partitions of 25

$i = 1;
while ($#a <= 5000) {
	undef @a;
	forpart { push @a, (join "-", @_) unless scalar grep { !is_prime($_) } @_ } $i;
	printf "%4d = %4d\n",  $i, $#a + 1;
 	$i++;
 }
 print "Answer = ".($i - 1);
