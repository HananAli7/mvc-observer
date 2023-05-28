package mvc_obs;

public class Main {
    public static void main(String[] args) {
        AuctionItem auctionItem = new AuctionItem("Painting", 100.0);
        Bidder bidder1 = new BidderImpl("Alice");
        Bidder bidder2 = new BidderImpl("Bob");

        AuctionController controller = new AuctionController();
        controller.addBidder(bidder1);
        controller.addBidder(bidder2);

        controller.startAuction();
    }
}