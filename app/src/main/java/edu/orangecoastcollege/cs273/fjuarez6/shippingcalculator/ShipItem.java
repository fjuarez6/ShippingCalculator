package edu.orangecoastcollege.cs273.fjuarez6.shippingcalculator;

/**
 * Created by frddy on 9/12/2016.
 */
public class ShipItem {

    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCoast;

    public ShipItem() {
        mWeight = 0.0;
        mBaseCost = 3.00;
        mAddedCost = 0.0;
        mTotalCoast = 0.0;
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;

        if (weight < 16) {

            mTotalCoast = mBaseCost;
        }
        else {

            mAddedCost = ((weight - 16) / 4) * (.50);
            mTotalCoast = mBaseCost + mAddedCost;
        }

    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCoast() {
        return mTotalCoast;
    }
}
