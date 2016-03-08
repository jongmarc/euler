Math::NumSeq::Totient;

use Math::NumSeq::Totient;
my $seq = Math::NumSeq::Totient->new;
$min = 10000000;
for ($i = 2; $i < 10000000; $i++) { 
	$value = $seq->ith($i);
	if (anagram($i, $value)){
		if ($i / $value < $min) {
			print $i." - ".$value."\n";
			$min = $i;	
		}
	}
}
print "Answer = ".$min."\n";

sub anagram
{
  my ($s1, $s2) = @_;

  return (join '', sort { $a cmp $b } split(//, $s1)) eq
         (join '', sort { $a cmp $b } split(//, $s2));
}