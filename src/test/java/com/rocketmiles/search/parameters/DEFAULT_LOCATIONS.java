package com.rocketmiles.search.parameters;

/**
 * default locations for search
 */
public enum DEFAULT_LOCATIONS {
    new_york(1, "New York City, NY, United States"),
    chicago(2, "Chicago, IL, United States"),
    london(3, "London, United Kingdom"),
    san_fran(4, "San Francisco, CA"),
    tokyo(5, "Tokyo, Japan"),
    la(6, "Los Angeles, CA, United States"),
    toronto(7, "Toronto, ON, Canada"),
    boston(8, "Boston, MA, United States"),
    vancouver(9, "Vancouver, BC, Canada"),
    vegas(10, "Las Vegas, NV, United States");

    private final int index;
    private final String displayName;

    private DEFAULT_LOCATIONS(int index, String displayName) {
        this.index = index;
        this.displayName = displayName;
    }

    public int getIndex() { return index; }
    public String getDisplayName() { return displayName; }
}