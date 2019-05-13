/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author Marcus Stewart
 */
public class TextAdventure {
    public static void main(String[] args) {
        Item item1 =  new Item("Bubbles", "This is item will be helpful to defeat the first creature.");
        Item item2 = new Item("Sword", "This is item will be helpful to defeat the great one.");
        Item item3 = new Item("Swoni", "This item will be help you defeat the feared one.");
    
        Creature creature1 = new Creature("Vilon", "He is the almight Vilon, you will need all your power to defeat it.", "Congratulations, you have just slained Vilon!", item1);
        Creature creature2 = new Creature("Mozar", "He is the great Mozar, even though it is small, it's attack is very powerful.", "Congratulations, you have just slained Mozar!", item2);
        Creature creature3 = new Creature("Ezar", "He is the feared Ezar, this will not be an easy task, use your ability to defeat it.", "Congratulations, you have just slained Ezar!", item3);
    
        Room room1 = new Room("Playzone");
        Room room2 = new Room("The timeout room");
        Room room3 = new Room("The snack lounge");
        Room room4 = new Room("The dungeon hall");
        Room room5 = new Room("The lazy hall");
        Room room6 = new Room("Janitors' closet");
        Room room7 = new Room("Ms. Waters' room");
        Room room8 = new Room("Locker room");
        Room room9 = new Room("Principle's office");
        Room room10 = new Room("The playground");    
        
        
        Exit room1to2 = new Exit("Play tunnel", "The tunnel is big enough for elementary schoolers to climb through.", "With some engineer from UND, the tunnel is connected to the vent of the second room.", room2);
        Exit room1to3 = new Exit("Tunnel", "This is surprisingly a big tunnel for how small the school is.", "Play tunnel is a good 2 ft. drop to the top of the vending machine, \"I'm going to jump to break the vent\". He breaks the vent and lands feet first on the vending machine, where all the candy is released from the machine. He then later jumps into the large pile of candy.", room3);
        Exit room2to1 = new Exit("The vent","Well this looks awfully familiar.","As he is climbing through the vent, he falls face first on the rubber mat.", room1);
        Exit room2to4 = new Exit("The other vent","\"Ouch!\" the kid says as he is crawling through the vent.","As he is getting inching near the next room, he notices kids, watch your back.", room4);
        Exit room2to7 = new Exit("The 3rd vent","This vent feels awfully like spit.","Well I mean this is Ms. Waters' vent and who knows what type of liquid she has in here or her room.", room7);
        Exit room3to4 = new Exit("Ladder","Don't ask why it's in here. P.S. The kids just want the candy.", "We are now climbing upstairs to one of the worst rooms in the school, be careful.", room4);
        Exit room4to2 = new Exit("Spikey hole","\"Ouch!\"", "The kid weaves his way to the next room without hurting himself.", room2);
        Exit room5to4 = new Exit("Bed 1","You were starting to get comfortable here!", "You just slid back into..*gets taken by the dragon*.", room4);
        Exit room5to7 = new Exit("Bed 2","This pillow has two sides you know!", "As you roll to the next room, the bed starts to get wet, with what though?", room7);
        Exit room5to9 = new Exit("Bed 3","Please don't gooo!", "You start to become scared, prepare yourself for the worst", room9);
        Exit room5to6 = new Exit("Bed 4","The peephole, why?", "You transform yourself to crawl through the peephole, now you can't see anything. ", room6);
        Exit room6to5 = new Exit("Peephole","This is the smallest path you'll have to crawl through.","Nice you have made it back to the lazy hall, congrats you are now officially lazy.", room5);
        Exit room7to2 = new Exit("The spit vent","You don't want to be here.", "I'd rather be in the spit vent than here, but it's too late to turn back now. Enjoy your time in the corner.", room2);
        Exit room7to5 = new Exit("The other spit vent","Back to bed.","You roll from the spit vent to the comfy bed.", room5);
        Exit room7to8 = new Exit("The 3rd spit vent","\"Why does it stink so much?\"", "Who knew that spit and sweat could be a great combination.", room8);
        Exit room8to7 = new Exit("Smelly Locker","Wow, someone actually built a locker room transportation.","You take the locker to get back to mystery liquid room.", room7);
        Exit room9to5 = new Exit("Door","How original, a door.","You open the door to get back in th..ZZZ.", room5);
        Exit room9to8 = new Exit("Underground Ladder","I knew every villain had one of these.", "Oh cool, now I can act like a villain for 2 seconds to get back to sweat.", room8);
        Exit room9to10 = new Exit("The window","Could this be it!?","You have escaped all the horrid transitions and are now here, nice.", room10);
        
    room1.setDescription("Although this might be the indoor playground, your destination is towards the outdoor playground, where it is less smelly.");
    room2.setDescription("This is where you spent most of you time in because of the crazy dares your classmates wanted to see.");
    room3.setDescription("This is where the teachers buy the snacks, not YOU.");
    room4.setDescription("This is rumored where the kids stay overnight because of the undareable acts they have committed.");
    room5.setDescription("You guessed it, it's lazy here.");
    room6.setDescription("Don't look in here!!");
    room7.setDescription("The boundry waters, jk just Ms. Waters' room!");
    room8.setDescription("Don't stay too long in here, it stinks.");
    room9.setDescription("This is one place I wished I have never visited, for you,...well it's too late.");
    room10.setDescription("This is what paradise looks like.");
    
    room1.setItem(item1);
    room4.setItem(item2);
    room8.setItem(item3);
    
    room5to9.setCreatureBlocks(true);
    room2to7.setCreatureBlocks(true);
    room9to10.setCreatureBlocks(true);
    
    room2to7.setRequiredItem(item2);
    
    room2.setCreature(creature1);
    room5.setCreature(creature2);
    room9.setCreature(creature3);
    
    room1.setExit1(room1to2);
    room1.setExit2(room1to3);
    room2.setExit1(room2to1);
    room2.setExit2(room2to4);
    room2.setExit3(room2to7);
    room3.setExit1(room3to4);
    room4.setExit1(room4to2);
    room5.setExit1(room5to4);
    room5.setExit2(room5to7);
    room5.setExit3(room5to9);
    room5.setSecretExit(room5to6);
    room6.setExit1(room6to5);
    room7.setExit1(room7to2);
    room7.setExit2(room7to5);
    room7.setExit3(room7to8);
    room8.setExit1(room8to7);
    room9.setExit1(room9to5);
    room9.setExit2(room9to8);
    room9.setExit3(room9to10);
   
    World world1 = new World(room1, room10);
    Player player1 = new Player("Luke Arteon", "An 8 year old ice cream eater");
    Game newGame = new Game(world1, player1);
    newGame.setStartText("You are trapped in this dungeon aka school; it's your job to defeat the creatures that are in your way to escape from school and become your dream profession, good luck!");
    newGame.setVictoryText("You are now free from school and you know can achieve your true dream of being a professional ice cream eater!");
    newGame.start();
    }
}