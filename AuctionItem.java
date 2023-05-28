package mvc_obs;

import java.util.ArrayList;
import java.util.List;

public class AuctionItem {
    private String itemName;
    private double initialBid;
    private double currentBid;
    private List<Bidder> bidders;

    public AuctionItem(String itemName, double initialBid) {
        this.itemName = itemName;
        this.initialBid = initialBid;
        this.currentBid = initialBid;
        this.bidders = new ArrayList<>();
    }

    public String getItemName() {
        return itemName;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        if (currentBid > this.currentBid) {
            this.currentBid = currentBid;
            notifyBidders();
        }
    }

    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
    }

    private void notifyBidders() {
        for (Bidder bidder : bidders) {
            bidder.update(this);
        }
    }
}