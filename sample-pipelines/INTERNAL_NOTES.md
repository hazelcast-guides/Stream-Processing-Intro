Areas for improvement

1. Inventory handling.  This problem also applies to the SQL version of the lab. We
   need to revisit.  We are checking the inventory level without reserving it, meaning 
   we can sell the same inventory multiple times.
2. The SQL part silently discards pick orders where there is no customer.  This can 
   be addressed with a left join.
3. For this scenario it makes sense to co-locate by customer.  This hasn't been addressed.
   It can be addressed in java.  It's not clear whether it can be addressed with SQL.
4. 
