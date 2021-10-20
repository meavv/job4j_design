where company_id != '5'

select person.name ,company_id, company.name from person join company on person.company_id = company.id

SELECT company.name, count(person.name) as count
FROM company  join person on person.company_id = company.id
GROUP BY company.name
having  count(person.name) in (
SELECT count(person.name) as count
FROM company  join person on person.company_id = company.id
GROUP BY company.name
	limit 1
)