open (FILE, "<p099_base_exp.txt");
@lines = <FILE>;
close(FILE);
$i = 1;
foreach $line (@lines) {
	print $i."\t".$line;
	$linenr{$line} = $i++;
}
print "\n\n";
foreach $line (@lines) {
	@newlines = sort {
		($ba, $ea) = split(/,/, $a);
		($bb, $eb) = split(/,/, $b);
		return $eb * log($bb) <=> $ea * log($ba);
		} @lines;
}

print $linenr{$newlines[0]};

