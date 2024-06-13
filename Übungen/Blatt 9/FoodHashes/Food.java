package FoodHashes;

//-----------------------------------------------------------------//
public class Food {
  //---------------------------------------------------------------//
  String category_;
  String name_;
  int    calories_;
  int    tasty_; //? Tasty goes from 1 to 10

  public Food (String category, String name, int calories, int tasty) {
    category_ = category; name_ = name; calories_ = calories;
    tasty_ = Math.clamp(tasty, 1, 10);
  }

  //---------------------------------------------------------------//
  public int hashCode() {
    int hash = 0;

    for (int i = 0; i < category_.length(); i++) {
      hash += (int)category_.charAt(i);
    }
    hash /= category_.length();
    int hash_name = 0;
    for (int i = 0; i < name_.length(); i++) {
      hash_name += (int)name_.charAt(i);
    }
    hash_name /= name_.length();

    hash += hash_name + calories_;
    hash *= tasty_;

    return hash;
  }

  //---------------------------------------------------------------//
  public String toString() {
     return (category_ + ":" + name_ + "; Cal.: " + calories_ + "; Tasty: " + tasty_ + "/10");
     // Example: Fish:Salmon; 123; 8/10
  }

  public boolean equals (Food obj) {
    return (category_.equals(obj.category_) &&
            name_.equals(obj.name_)         &&
            calories_ == obj.calories_      &&
            tasty_ == obj.tasty_);
  }
}
