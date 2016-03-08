use Math::Roman qw/roman/;

 my @trans = (
                [M  => 1000],     [CM => 900], 
                [D  => 500],      [CD => 400], 
                [C  => 100],      [XC => 90],
                [L  => 50],       [XL => 40],
                [X  => 10],       [IX => 9],
                [V  => 5],        [IV => 4],
                [I  => 1],
 );

open (FILE, "<p089.txt") || die "error";
  @lines = <FILE>;
close(FILE);

foreach $line (@lines) {
  chomp($line);
  #print $line;
  $a += length($line) - length(roman(&decode($line)));
  print &decode($line)." = ".roman(&decode($line))."\n";

}
print "Answer = ".$a."\n";

sub decode {
        my $r = shift;
        my $n = 0;
        foreach my $pair (@trans) {
          my ($k, $v) = @$pair;
          $n += $v while $r =~ s/^$k//i;
        }
        return $n;
  }

 
