package mvc_obs;

public class BidderImpl implements Bidder {
    private String name;

    public BidderImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(AuctionItem auctionItem) {
        System.out.println(name + " has placed a bid of " + auctionItem.getCurrentBid() + " for " + auctionItem.getItemName());
    }
    
    
}

