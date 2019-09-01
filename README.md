# Returnly Java Exercise (Solution)

## Response structure

When the invocation is made, a JSON is got as response with the following fields:

- totalOrders: Total number of orders
- uniqueUsers: Number of unique customers
- mostFrequentlyOrderedItemName: Most frequently ordered item
- leasFrequentlyOrderedItemName: Least frequently ordered item
- medianOrderValue: Median order value
- orderShortestInterval: Shortest interval between any two consecutive orders placed by the same customer

## Build Docker images

In order to build an image containing the deployment, create first the image with:

`docker build -t returnly_assessment .`

Then create and deploy a container with:

`docker run -d -p 8080:8080 --name returnly_deployment returnly_assessment`