package mvc_obs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import mvcObserver_.AuctionView;

//import mvcObserver_.AuctionView;

public class AuctionController {
    private AuctionItem auctionItem;
    /*private List<Bidder> bidders;

    public AuctionController(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
        this.bidders = new ArrayList<>();
    }*/
    private Bidder alice;
    private Bidder bob;

    public AuctionController() {
        this.auctionItem = new AuctionItem("Painting", 100.0);
        this.alice = new BidderImpl("Alice");
        this.bob = new BidderImpl("Bob");
        auctionItem.addBidder(alice);
        auctionItem.addBidder(bob);
        
    }

    public void addBidder(Bidder bidder) {
        //bidders.add(bidder);
        auctionItem.addBidder(bidder);
    }

    public void removeBidder(Bidder bidder) {
        //bidders.remove(bidder);
        auctionItem.removeBidder(bidder);
    }

  public void startAuction() {
        System.out.println("Starting auction for " + auctionItem.getItemName());
        System.out.println("Initial bid is " + auctionItem.getCurrentBid());

        while (true) {
            double newBid = getNewBid();
            if (newBid == -1) {
                System.out.println("Auction for " + auctionItem.getItemName() + " has ended. Final bid is " + auctionItem.getCurrentBid());
                break;
            }
            auctionItem.setCurrentBid(newBid);}
        }
	 

    private double getNewBid() {
        // This method should prompt the user for a new bid and return the value entered,
        // or -1 if the auction should end.
        // For simplicity, we'll just return a random number between 0 and 200 for this example.
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

    	//BidderImpl auctionView = new BidderImpl();

        System.out.println("Enter your bid (or -1 to end the auction): ");
        double bid = scanner.nextDouble();
        if (bid == -1) {
            return -1;
        }
        while (bid <= auctionItem.getCurrentBid()) {
            System.out.println("Your bid must be higher than the current bid (" + auctionItem.getCurrentBid() + ")");
            System.out.println("Enter your bid (or -1 to end the auction): ");
            bid = scanner.nextDouble();
            if (bid == -1) {
                return -1;
            }
        }
        return bid;
    }
}
