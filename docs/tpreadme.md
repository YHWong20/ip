### Adding an item: `add`

> This allows you to add a new item to start keeping track of in your inventory.

#### Adding a Retail item

Format: `add -re -n ITEM_NAME -d ITEM_DESCRIPTION -s SALE_PRICE -c COST_PRICE [-q ITEM_QUANTITY] [-t THRESHOLD]`

* `-re` specifies that this is a Retail item.
* `ITEM_NAME`, `ITEM_DESCRIPTION`, `SALE_PRICE` and `COST_PRICE` must be specified.

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong> The <code>ITEM_NAME</code> field must be unique for each item in your inventory. If you wish to add different batches of the same item with different expiry dates, consider naming them with a suffix, e.g., <code>Milo_1</code>, <code>Milo_2</code>.
</div>

* All other fields are optional.
* If `ITEM_QUANTITY` is not specified, a default value of `0` will be assigned to it.
This allows you to create a placeholder for an item in your inventory you've yet to receive any stock of.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> Once you've received stock of the item, you can call the <a href="#restocking-an-item-restock"><code>restock</code></a> command to increase the stocked quantity of the item.
</div>

* If `THRESHOLD` is not specified, a default value of `1` will be assigned to it.
* There is no need to include the currency. A `$` sign will be appended to the prices.
* Retail items do not have an `EXPIRY_DATE` field, hence the flag `-e` is not used.

Examples:

- `add -re -n lego -d toys -q 350 -s 102.00 -c 34.32 -t 50`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [R] lego
       description: toys
       quantity: 350
       cost price: $34.32
       sale price: $102.00
       threshold: 50
   -------------------------------------------------------------
   ```
- `add -re -n hammer -d tools -q 20 -s 9.00 -c 4.39 -t 10`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [R] hammer
       description: tools
       quantity: 20
       cost price: $4.39
       sale price: $9.00
       threshold: 10
   -------------------------------------------------------------
   ```

#### Adding a Perishable Retail item

Format: `add -re -n ITEM_NAME -d ITEM_DESCRIPTION -e EXPIRY_DATE -s SALE_PRICE -c COST_PRICE [-q ITEM_QUANTITY] [-t THRESHOLD]`

* The command to add a Perishable Retail item is similar to adding a Retail item.
* An additional flag , `-e`, is used here to include the `EXPIRY_DATE`, hence signifying a Perishable Retail item.

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong> Ensure that the provided date is in <code>DD-MM-YYYY</code> format. For example, <strong>20 January 2024</strong> is represented as <code>20-01-2024</code>.
</div>

Examples:

- `add -re -n apple -d fruit -q 50 -e 12-12-2024 -s 1.00 -c 0.39 -t 10`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [P][R] apple
       description: fruit
       quantity: 50
       cost price: $0.39
       sale price: $1.00
       threshold: 10
       expiry date: 12-12-2024
   -------------------------------------------------------------
   ```
- `add -re -n tuna fish -d seafood -q 5 -e 02-11-2024 -s 10 -c 4.50`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [P][R] tuna fish
       description: seafood
       quantity: 5
       cost price: $4.50
       sale price: $10.00 
       threshold: 1
       expiry date: 02-11-2024
   -------------------------------------------------------------
   ```

#### Adding an Operational item

Format: `add -op -n ITEM_NAME -d ITEM_DESCRIPTION -c COST_PRICE [-q ITEM_QUANTITY] [-t THRESHOLD]`

* `-op` specifies that this is an Operational Item.
* `ITEM_NAME`, `ITEM_DESCRIPTION` and `COST_PRICE` must be specified.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> Once you've received stock of the item, you can call the <a href="#restocking-an-item-restock"><code>restock</code></a> command to increase the stocked quantity of the item.
</div>

* All other fields are optional.
* If `ITEM_QUANTITY` is not specified, a default value of `0` will be assigned to it.
This allows you to create a placeholder for an item in your inventory you've yet to receive any stock of.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> Once you've received stock of the item, you can call the <a href="#restocking-an-item-restock"><code>restock</code></a> command to increase the stocked quantity of the item.
</div>

* If `THRESHOLD` is not specified, a default value of `1` will be assigned to it.
* There is no need to include the currency. A `$` sign will be appended to the prices.
* `-s` and `-e` are not used as there are no `SALE_PRICE` and `EXPIRY_DATE` fields for an Operational Item.

Examples:

- `add -op -n light bulbs -d lighting -q 5 -c 2.30 -t 3`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [O] light bulbs
       description: lighting
       quantity: 5
       cost price: $2.30
       threshold: 3
   -------------------------------------------------------------
   ```

#### Adding a Perishable Operational item

Format: `add -op -n ITEM_NAME -d ITEM_DESCRIPTION -e EXPIRY_DATE -c COST_PRICE [-q ITEM_QUANTITY] [-t THRESHOLD]`

* The command to add a Perishable Operational item is similar to adding an Operational item.
* An additional flag , `-e`, is used here to include the `EXPIRY_DATE`, hence signifying a Perishable Operational item.

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong> Ensure that the provided date is in <code>DD-MM-YYYY</code> format. For example, <strong>20 January 2024</strong> is represented as <code>20-01-2024</code>.
</div>

* `-s` is not used as there is no `SALE_PRICE` for a Perishable Operational Item.

Examples:

- `add -op -n milk -d to make coffee -q 2 -e 03-10-2024 -c 1.30`<br>
   ```text
   -------------------------------------------------------------
   Noted! I have added the following item into your inventory:
    
   [P][O] milk
       description: to make coffee
       quantity: 2
       cost price: $1.30
       threshold: 1
       expiry date: 03-10-2024
   -------------------------------------------------------------
   ```

[Back to table of contents](#table-of-contents)

---
<br>

### Searching for an item: `search`

> This allows you to search for items in your inventory, filtering results through a number of item-specific fields.

Format: `search -n NAME_QUERY -d DESCRIPTION_QUERY -q QUANTITY_RANGE -c COST_PRICE_RANGE -s SALE_PRICE_RANGE -e EXPIRY_DATE_RANGE -l NUMBER_OF_RESULTS`

- At least one of `-n`, `-d`, `-q`, `-c`, `-s`, or `-e` must be set.
- `NAME_QUERY` and `DESCRIPTION_QUERY` perform a case-insensitive search on the name and description fields of inventory items respectively.
- `RANGE` searches take the form `{min_value}..{max_value}` and are inclusive of the minimum or maximum values specified.
  - At least one of `min_value` or `max_value` is required.
  - Omitting `min_value` searches for everything up to and including the `max_value`.
  - Omitting `max_value` searches for everything with at least `min_value`.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong><br> For example, to search for items with a quantity up to and including 20, we should format our query as:<br>
<code>-q ..20</code>.<br>
To search for items that cost at least $15, we should format our query as:<br>
<code>-c 15..</code>.
</div>

- `EXPIRY_DATE_RANGE` is similar to the above range arguments: except dates need to be specified in the format `dd-MM-YYYY`.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡<strong>Tip:</strong><br> For example, to search for items with an expiry date between 20 January 2024 and 30 January 2024, we should format our query as:<br>
<code>-e 20-01-2024..30-01-2024</code>.
</div>

- Shows the first `NUMBER_OF_RESULTS` results if set, else all matching results are shown.

**Examples:**

- `search -n snake plant`
  Will return all items with names containing **snake plant**, such as "snake plant" and "snake plant seeds".
- `search -l 6 -c ..5`
  Will return the first 6 items that cost up to and including $5.00.
- `search -s 20..30`
  Will return all items with sale prices between $20 and $30 (inclusive).
- `search -l 1 -e 11-11-2023.. -d seeds`
  Will return the first item expiring on or after 11 November 2023 and that contain the word "seeds" in its description.
- `search -q 50.. -e 17-09-2023..23-11-2023`
  Will return all items with current quantity at or above 50 and that expire between 17 September 2023 and 23 November 2023 (inclusive).

[Back to table of contents](#table-of-contents)

---
<br>

### Listing current inventory: `list`

> This allows you to list out all items that you have in your inventory list. 
> You can also use this command to display your inventory list, sorted based on cost price, sale price, profit, or expiry date.

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> Indexes of the items listed, whether in a sorted list or unsorted list, can be used as references for <code>delete</code> and <code>update</code> commands.
</div>

#### List Inventory (Unsorted)

View the inventory in the order items were added:

Format: `list`

#### List Inventory (Sorted)

BinBash also allows you to sort your inventory in ascending order based on different criteria. This means that items 
with the lowest 'values' will be showed first, whilst items with the highest 'values' will be showed last. The different
'values' that BinBash can sort by can be seen below:

| Flag | Description                                |
|------|--------------------------------------------|
| `-c` | Sort by cost price                         |
| `-s` | Sort by sale price                         |
| `-p` | Sort by profit                             |
| `-e` | Sort by expiry date (for perishable items) |

Format: `list -FLAG`

Example: 

Suppose you have the following items in your inventory:
- Item A (Perishable Retail), Cost Price: $5, Sale Price: $15, Expiry Date: 01-05-2023
- Item B (Perishable Retail), Cost Price: $10, Sale Price: $12, Expiry Date: 15-04-2023
- Item C (Perishable Operational), Cost Price: $3, Expiry Date: 10-07-2023
- Item D (Non-perishable Retail), Cost Price: $7, Sale Price: $14

Using `list -c`, BinBash sorts all items by cost price in ascending order:
- Item C, Cost Price: $3
- Item A, Cost Price: $5
- Item D, Cost Price: $7
- Item B, Cost Price: $10

Using `list -e`, BinBash sorts the items in order of which items will expire first. Notice how BinBash will filter out 
non-perishable items (Item D) and sort the remaining items by their expiry date:
- Item B, Expiry Date: 15-04-2023
- Item A, Expiry Date: 01-05-2023
- Item C, Expiry Date: 10-07-2023

Similarly, you can use `list -s` to sort the items by sale price and `list -p` to sort by profit. Once again, 
note that for sorting the items by sale price and by profit, operational items like Item C will not appear in these 
sorted lists as they do not have a sale price.

[Back to table of contents](#table-of-contents)

---
<br>

### Selling an item: `sell`

> This allows you to decrement the quantity of an item after it has been sold.

#### Selling an item using item name

Format: `sell -n ITEM_NAME -q ITEM_QUANTITY`

* Both flags `-n` and `-q` are mandatory.
* The flag `-n` is used, meaning that the `item name` is used as an identifier to identify the item you wish to sell.
* The quantity given to this command represents the amount of item that you want to sell. This amount will be reduced
  from the existing quantity of the item in the inventory list.

Examples: 

- `sell -n oranges -q 20` This will deduct the quantity of "oranges" in your inventory list by 20.
- `sell -n lego bricks -q 219` This will deduct the quantity of "lego bricks" in your inventory list by 219.

#### Selling an item using item index

Format: `sell -i ITEM_INDEX -q ITEM_QUANTITY`

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> To determine the <code>index</code> of an item in your inventory, call the <code>list</code> command first, and note down the number displayed next to your item of interest.
</div>

* Both flags `-i` and `-q` are mandatory.
* The flag `-i` is used, meaning that the `item index` is used as an identifier to identify the item you wish to sell.

Examples:
- `sell -i 1 -q 50` This will decrease the quantity of the item at index 1 in your inventory list by 50.
- `sell -i 3 -q 35` This will decrease the quantity of the item at index 3 in your inventory list by 35.

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong><br> 
<li>Only one item identifier flag, <code>-n</code> or <code>-i</code>, can be used with the <code>sell</code> command to identify the item that you want to sell.</li>
<li>There must be a minimum of one flag used, excluding the <code>-n</code> or <code>-i</code> flag.</li>
</div>

[Back to table of contents](#table-of-contents)

---
<br>

### Restocking an item: `restock`

> This allows you to increment the quantity of an item after it has been restocked.

#### Restocking an item using item name

Format: `restock -n ITEM_NAME -q ITEM_QUANTITY`

* Both flags `-n` and `-q` are mandatory.
* The flag `-n` is used, meaning that the `item name` is used as an identifier to identify the item you wish to restock.
* The quantity given to this command represents the amount of item that you want to restock. This amount will be added
  to the existing quantity of the item in the inventory list.

Examples:

- `restock -n apples -q 50` This will add the quantity of "apples" in your inventory list by 50. .

#### Restocking an item using item index

Format: `restock -i ITEM_INDEX -q ITEM_QUANTITY`

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> To determine the <code>index</code> of an item in your inventory, call the <code>list</code> command first, and note down the number displayed next to your item of interest.
</div>

* Both flags `-i` and `-q` are mandatory.
* The flag `-i` is used, meaning that the `item index` is used as an identifier to identify the item you wish to update.

Examples:
- `restock -i 2 -q 10` This will add the quantity of the item at index 2 in your inventory list by 10.

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong><br> 
<li>Only one item identifier flag, <code>-n</code> or <code>-i</code>, can be used with the <code>restock</code> command to identify the item that you want to sell.</li>
<li>There must be a minimum of one flag used, excluding the <code>-n</code> or <code>-i</code> flag.</li>
</div>

[Back to table of contents](#table-of-contents)

---
<br>

### Updating an item: `update`

> This command allows you to modify the details of an existing item in the inventory. You can identify the item that you want to update, by
> specifying the name of the object, or its index number as displayed in the inventory list.

#### Updating an item using item name

Format: `update -n ITEM_NAME [-d ITEM_DESCRIPTION] [-q ITEM_QUANTITY] [-e EXPIRY_DATE] [-s SALE_PRICE] [-c COST_PRICE]
[-t THRESHOLD]`

* The flag `-n` is used, meaning that the `item name` is used as an identifier to identify the item you wish to update.
This flag is required.
* Using the `item name` identifier will only update the first occurring item in the list should there be any duplicates.
* All other flags are optional, depending on what details you wish to update.

Examples:
- `update -n banana -d ripe fruit -q 30 -e 10-10-2024 -c 0.50`
Updates the description of the item named "banana" to "ripe fruit", its quantity to 30, its expiry date to 10 October 
2024 and its cost price to $0.50. Other information remain unchanged.
- `update -n "printer paper" -s 15.00 -t 5`
Updates the sale price of the item named "printer paper" to $15.00 and its threshold to 5.
- `update -n "chicken sandwich" -q 50 -e 01-01-2025 -t 10`
Updates the quantity of the item named "chicken sandwich" to 50, its expiry date to 1 January 2025 and its threshold 
to 10.

 
#### Updating an item using item index

Format: `update -i ITEM_INDEX [-d ITEM_DESCRIPTION] [-q ITEM_QUANTITY] [-e EXPIRY_DATE] [-s SALE_PRICE] [-c COST_PRICE]
[-t THRESHOLD]`

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> To determine the <code>index</code> of an item in your inventory, call the <code>list</code> command first, and note down the number displayed next to your item of interest.
</div>

* The flag `-i` is used, meaning that the `item index` is used as an identifier to identify the item you wish to update.
* To know the `item index`, we encourage you to first use the command `list` to find out the index of your item of 
interest.
* All other flags are optional,depending on what details you wish to update.

Examples:
- `update -i 2 -d "office supplies" -s 20.00`
Updates the description of the item at index 2 to "office supplies" and its sale price to $20.00. Other information 
remains unchanged.
- `update -i 4 -q 10 -c 2.00 -t 2`
Updates the quantity of the item at index 4 to 10, its cost price to $2.00, and its threshold to 2.


<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong><br> 
<li>Only one item identifier flag, <code>-n</code> or <code>-i</code>, can be used with the <code>update</code> command to identify the item that you want to sell.</li>
<li>There must be a minimum of one flag used, excluding the <code>-n</code> or <code>-i</code> flag.</li>
</div>

[Back to table of contents](#table-of-contents)

---
<br>

### Deleting an item: `delete`

> This lets you delete an item from the inventory. You can identify an item by its name, or its index number (as displayed in the inventory list).

#### Deleting an item using item index

Format: `delete -i ITEM_INDEX`

<div id="tipCallout" style="padding: 1em; border: 0 solid #9ee09e;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #e6f5e6;">
💡 <strong>Tip:</strong> To determine the <code>index</code> of an item in your inventory, call the <code>list</code> command first, and note down the number displayed next to your item of interest.
</div>

* `ITEM_INDEX` must be specified.
* `ITEM_INDEX` specified must exist in the inventory, otherwise no item will be deleted.
* Index of items can be viewed using the `list` command.

Examples:
- `list` followed by`delete -i 1` Deletes the item with index of 1.

#### Deleting an item using item name

Format: `delete -n ITEM_NAME`

* `ITEM_NAME` must be specified.
* `ITEM_NAME` specified must be the exact name of the item.
* `ITEM_NAME` is case-sensitive. Capital letters are treated differently from lower case letters, e.g "apple" is different from "APPLE"
* If there are no items with item names matching `ITEM_NAME`, no items will be deleted.
* If there are items with the same `ITEM_NAME`, only the first instance of item with `ITEM_NAME` will be deleted.
* Item names of items in the inventory can be viewed using the `list` command.

Examples:
- `list` followed by `delete -n cookie` Deletes the first item named "cookie".

<div id="warningCallout" style="padding: 1em; border: 0 solid #feb144;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #fff8e6;">
❗ <strong>Warning:</strong> Item name is case-sensitive. So items with names as "COOKIE", "Cookie", etc.  will not be deleted.
</div>

- `list` followed `delete -n tissue paper` Deletes the first item named "tissue paper".

<div id="warningCallout" style="padding: 1em; border: 0 solid #feb144;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #fff8e6;">
❗ <strong>Warning:</strong> Item name is case-sensitive. So items with names as "TISSUE PAPER", "Tissue Paper", etc. will not be deleted.
</div>

[Back to table of contents](#table-of-contents)

---
<br>

### Calculating the total profit: `profit`

> This command allows you to view the total profit that you've earned, based on the revenue and cost of items in your inventory.

Format: `profit`

This command computes the total profit by subtracting the total cost from the total revenue of all items in your inventory.
The output will display the total profit in the format as seen below:
```text
-------------------------------------------------------------
Total profit: $6907.40

-------------------------------------------------------------
```

[Back to table of contents](#table-of-contents)

---
<br>

### Exiting the application: `bye`, `exit`, `quit`

> Any one of these commands allow you to exit the application.

After a long day at work, it's time to take a rest! You can safely quit the application using this command.

Format: `bye`, `exit`, `quit`

<div id="infoCallout" style="padding: 1em; border: 0 solid #9ec1cf;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #eef9fc;">
ℹ️ <strong>Note:</strong> BinBash will save the state of your current inventory, and you can always come back to it later.
</div>

[Back to table of contents](#table-of-contents)

---
<br>

### Saving and Loading data

Unsure as to how you can save your BinBash data? Don't worry! Your data is automatically saved to your local storage. No manual saving of data is required.

Similarly, your saved data will be automatically loaded into BinBash when you start the application. If no previous save data was found, the application starts on a clean state.

<div id="warningCallout" style="padding: 1em; border: 0 solid #feb144;border-left-width: 4px;border-radius: 6px; margin-top: 1rem; margin-bottom: 1rem; padding: 1em; border-radius: 4px; color: #293132; background-color: #fff8e6;">
❗ <strong>Warning:</strong><br>
For advanced users, BinBash data is stored locally as a <code>.txt</code> file in your BinBash install location:
<br><code>< Location of binbash.jar >/data/items.txt</code>.
<br><br>
Do exercise caution when directly editing this file, as BinBash <strong>will not load</strong> corrupted data (i.e., data that is not formatted correctly). 
<br>
We highly recommended that you take a backup of your save file before editing it.
</div>

[Back to table of contents](#table-of-contents)

---
<br>
