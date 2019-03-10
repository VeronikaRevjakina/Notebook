public class Main {

    public static void main(String[] args) {

        Note note0=new Note(0,"A","abc1");
        Note note1=new Note(1,"Ab","abc2");
        Note note2=new Note(2,"Abc","abc3");

//checking Notebook() --empty output
        Notebook book1=new Notebook();
        book1.showAllNotes();

/*checking Notebook(Note[] notesIn)
 --output:  id 0 title: A context: abc1
            id 1 title: Ab context: abc2
            id 2 title: Abc context: abc3
*/
        Note[] notes2={note0,note1,note2};
        Notebook book2=new Notebook(notes2);
        book2.showAllNotes();

/*checking addNote
 --output:  id 0 title: A context: abc1
            id 1 title: Ab context: abc2
            id 2 title: Abc context: abc3
*/
        book1.addNote(note0);
        book1.addNote(note1);
        book1.addNote(note2);
        book1.showAllNotes();

/*checking deleteLastNote
 --output:  id 0 title: A context: abc1
            id 1 title: Ab context: abc2
*/
        book1.deleteLastNote();
        book1.showAllNotes();


/*checking deleteNoteById
 --output:  id 0 title: A context: abc1
            id 2 title: Abc context: abc3
*/

        book2.deleteNoteById(1);
        book2.showAllNotes();

/*checking getNoteById
 --output:  id 1 title: Ab context: abc2
*/
        book1.getNoteById(1);

/*checking changeFullNote
 --output:  id 1 title: Ab context: abc2
            id 3 title: Abcd context: abc3
*/
book1.getNoteById(1).changeFullNote(3,"Abcd","abc3");

//Checking negative cases

Notebook book3=new Notebook(notes2);

/*checking deleteNoteById
 --output:  Exception for deleteNoteById with wrong Id worked
*/
try { book3.deleteNoteById(6);}
catch(IndexOutOfBoundsException e)
{
    System.out.println( "Exception for deleteNoteById with wrong Id worked");
}

/*checking getNoteById
 --output:  Exception for getNoteById with wrong Id worked
*/
try { book3.getNoteById(5);}
catch(IndexOutOfBoundsException e)
{
    System.out.println( "Exception for getNoteById with wrong Id worked");
}

book3.deleteLastNote();
book3.deleteLastNote();
book3.deleteLastNote();

/*checking deleteLastNote
 --output:  Exception for deleteLastNote for empty notebook worked
*/
try { book3.deleteLastNote();}
catch(IndexOutOfBoundsException e)
{
    System.out.println( "Exception for deleteLastNote for empty notebook worked");
}

/*checking changeFullNote
 --output:  Exception for changeFullNote for negative Id worked
*/
Note note4=new Note(3,"Abcd","abc3");
try {  note4.changeFullNote(-5,"Abcd","abc3");}
catch(IndexOutOfBoundsException e)
{
    System.out.println( "Exception for changeFullNote for negative Id worked");
}

/*Checking expansion in addNote
 --output:       2 1   2 2  4 3  4 4  8 5  8 6  8 7  8 8  16 9  16 10
*/
        Notebook book5=new Notebook();
        Notebook book6=new Notebook();
        for(int i=0;i<10;i++){
            book5.addNote(note0);
            book6.addNote(note0);
            System.out.println(book5.getNotes().length);
            System.out.println(book5.getLast());
        }

/*Checking narrowing in deleteLastNote
 --output:      16 9  8 8  8 7  8 6  8 5  4 4  4 3  2 2  1 1  0 0

*/
        for(int j=0;j<10;j++){
            book5.deleteLastNote();
            System.out.println(book5.getNotes().length);
            System.out.println(book5.getLast());
        }
/*Checking narrowing in deleteNoteById
 --output:      15 9  14 8  13 7  6 6

*/
        book6.deleteNoteById(5);
        System.out.println(book6.getNotes().length);
        System.out.println(book6.getLast());
        book6.deleteNoteById(7);
        System.out.println(book6.getNotes().length);
        System.out.println(book6.getLast());
        book6.deleteNoteById(3);
        System.out.println(book6.getNotes().length);
        System.out.println(book6.getLast());
        book6.deleteNoteById(1);
        System.out.println(book6.getNotes().length);
        System.out.println(book6.getLast());

    }
}



