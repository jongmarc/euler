
$i=0;

sub permutation {
	my ($perm,@set) = @_;
	show($perm) || return unless (@set);
	permutation($perm.$set[$_],@set[0..$_-1],@set[$_+1..$#set]) foreach (0..$#set);
}
my @input = (qw/0 1 2 3 4 5 6 7 8 9/);
permutation('',@input);

sub show{
	($text) = @_;
	#print "$text\n";
	$i++;
	if ($i==1000000) { print "$text\n";; exit(0);}
}