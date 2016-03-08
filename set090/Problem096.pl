use Games::Sudoku::Solver qw(:Minimal set_solution_max count_occupied_cells);

# specify a Sudoku as flat array (this one has 10 solutions)
open (FILE, "<p096_sudoku.txt");
$y = 0;
while ($line = <FILE>) {
	$x = 0;
	$line = <FILE>;
	foreach $item ( split /,/, $line ) {
		$matrix[$y][$x++] = $item;
	}
	$y++;
}
close (FILE);




    my @sudoku;                                     # the Sudoku data structure
    my @solution;                                   # the solution data structure

    sudoku_set( \@sudoku, \@sudoku_raw );           # convert raw to internal representation

    print "\n===== Sudoku =====\n";
    sudoku_print( \@sudoku );                       # print the Sudoku


    my  $cells_occupied = count_occupied_cells( \@sudoku ); # some statistics
    print "\n", $cells_occupied, " cells occupied, ",
             81-$cells_occupied, " cells free\n";

    set_solution_max(4);                            # stop having 4 solutions found

    my $solutions = sudoku_solve( \@sudoku, \@solution);    # solve the Sudoku

    foreach my $n ( 1..$solutions ) {               # print the solutions
        print "\n--- solution $n ---\n";
        sudoku_print( $solution[$n-1] );
    }