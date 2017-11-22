import java.util.Scanner;
class Book{
    Scanner s = new Scanner(System.in);
    //Nested class for each entry
    class Entry{
        private String first;
        private String last;
        private String address;
        private String email;
        private int phone_no;
        private int mobile_no;
        
        Entry(String first, String last, String address, String email, int phone_no, int mobile_no){
            this.first = first;
            this.last = last;
            this.address = address;
            this.email = email;
            this.phone_no=phone_no;
            this.mobile_no=mobile_no;
        }
        
        public Entry() {
			// TODO Auto-generated constructor stub
		}

		public void readEntry(){
            System.out.println("First Name:"+first );
            System.out.println("Last Name:"+last );
            System.out.println("Address:"+address );
            System.out.println("Email:"+email );
            System.out.println("Phone no:"+phone_no);
            System.out.println("mobile no:"+mobile_no);
        }
    }


    //Keeps track of how many entries are in the book
    private int entries = 0;
    Entry[] contents;
    public void initEntries(int e){
        contents = new Entry[e];
        for (int i = 0;i<contents.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
            contents[i] = new Entry();
        }
    }
    public int getEntries(){
        return contents.length;
    }
    //Adds an entry to the book
    public void add(String first, String last, String address, String email, int phone_no, int mobile_no){
        if (entries<contents.length){
        contents[entries] = new Entry(first, last, address, email, phone_no, mobile_no);
        entries++;
        }
        else System.out.println("Error: book is full");
    }

    //Removes an entry from the book
    public void remove(int entry){
        if (entries>0){
            contents[entry] = new Entry();
            for (int i = 0;i<entries-entry;i++){
                if (entry+1==entries) contents[entry] = new Entry();
                else{
                    Entry temp = contents[entry+i];
                    contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards.
                    contents[entry+i+1] = temp;
                }
            }
            entries--;
            }
            else System.out.println("Error: book is empty.");
    }

    //Changes the values of an entry
    public void edit(String first, String last, String address, String email, int selection, int phone_no, int mobile_no){
        contents[selection].first = first;
        contents[selection].last = last;
        contents[selection].address = address;
        contents[selection].email = email;
        contents[selection].phone_no = phone_no;
        contents[selection].mobile_no = mobile_no;
        
    }

    //Sorts the book based on a part of the entry
    //int n is used to tell which part of the entries to base the sort on
    public void sort(int n){
        for(int i = 0;i<contents.length;i++){
            for (int j = 0;j<contents.length;j++){
                switch(n){
                    case 1:
                        if (contents[i].first.compareTo(contents[j].first)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 2:
                        if (contents[i].last.compareTo(contents[j].last)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 3:
                        if (contents[i].address.compareTo(contents[j].address)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    case 4:
                        if (contents[i].email.compareTo(contents[j].email)<0){
                            Entry temp = contents[i];
                            contents[i] = contents[j];
                            contents[j] = temp;
                        }
                        break;
                    default: 
                        System.out.println("Error: invalid field");
                        break;
                }
            }
        }
    }
    public void addFromCopy(Entry e){
        if (entries<contents.length){
            contents[entries] = e;
            entries++;
            }
            else System.out.println("Error: book is full");
    }

}
