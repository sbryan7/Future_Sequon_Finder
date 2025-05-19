# Future Sequon Finder

A Java-based GUI application for identifying existing N-linked glycosylation sequons and predicting the emergence of new sequons in viral surface proteins. Developed by Shane Bryan and Dr. Martin S. Zand, 2025.

## System Requirements

- Java JDK 8 or later (tested with JDK 21)
- No external libraries required

## How to Build and Run: From Source (IntelliJ IDEA)

1. Clone the repository:
   git clone https://github.com/sbryan7/FutureSequonFinder.git
2. Open the project in IntelliJ IDEA
3. Build and run `Main.java`

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Citation

This tool was developed as part of a manuscript currently under review at *PLOS ONE*. Once accepted, this section will be updated with the appropriate citation and DOI.

## Using the program

### Basic Functionality

Future Sequon Finder first processes a nucleotide sequence beginning with a start codon from the user and converts it into an amino acid sequence.
The resulting amino acid sequence is then scanned for N-linked glycosylation sequons and sites that may become glycosylation sequons using the known N-linked glycosylation sequon definition (N - !P - S/T).
These sites will be sorted into the following categories:

Near-sequon       - A site that may become an N-linked glycosylation sequon if a single amino acid is changed

Very near-sequon  - A site that may become an N-linked glycosylation sequon if a single nucleotide is changed

Ultra near-sequon - A site that may become an N-linked glycosylation sequon if a single nucleotide is changed, and the resultant change does not alter the charge or polarity of the amino acid

### Surface accessibility feature

The 'GetArea' surface accessibility feature allows users to pair their nucleic acid sequence with surface accessability results from https://curie.utmb.edu/getarea.html to improve predictive accuracy.
To use this feature, users will need a three-dimensional structure of their protein of interest saved as a PDB file.
When using this feature, it is critical that the amino acid sequence generated from the nucleotide input matches the amino acid sequence AND position numbers of the PDB file provided to the GetArea program.
When using GetArea, use the default probe radius of 1.4 angstrom.
To input the results from GetArea into Future Sequon Finder, simply copy and paste the query results from GetArea, starting with the first amino acid, into the associated input box in FSF after pasting the corresponding nucleotide sequence in the box above.


Note: Do not include the 'Probe radius' or any of the columb titles in the input for your GetArea results, as this will result in an error.


If all amino acids in the GetArea result allign with the amino acids generated from the nucleotide sequence, the sidechain surface exposure ratio will be saved to each exposed amino acid.
Any amino acid associated with the asparagine (N) site of a near-sequon that has a side chain exposure ratio exceeding 15% will be marked as exposed.

### Mutation Frequency Feature

The 'MEGA' mutation frequency feature allows users to incorporate site-specific mutation frequency data to sort near-sequpons based on the relative mutation frequency of the site where their mismatched AA is located.
After each category is sorted, the rankings of all near-sequons are displayed to the user with those whose mismatched AA is most likely to mutate ranked at the top of the list.
To use this feature, a list of nucleotide sequences relating to and predating the sequence of interest must first be obtained. These sequences provide evolutionary context for the sequence of interest showing which regions are most likely to change over time.
All related sequences must then be aligned (for this we recommend MUSCLE), saved as a .meg file, and then imported into the Molecular Evolutionary Genetics Analysis (MEGA) tool. This tool can be installed from https://mega.io/desktop.
Site-specific mutation rates can now calculated in MEGA. We reccomend using the Le and Gascuel model for most proteins. Results may then be copied directly into their associated input box in FSF.

