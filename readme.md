# Book Shop

Browse by category, search for your favorite titles, and engage with the community through comments. Easily add books to your cart, breeze through checkout and tracking your oder. 

## Installation

Can install demo by docker

1.Clone my project

2.Copy temp data to database container
```cmd
docker exec -i database mysqldump -uroot -p29082001 bookstore < db.sql
```

3.Run cmd to run demo

```cmd
docker-compose up -d
```

```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.
